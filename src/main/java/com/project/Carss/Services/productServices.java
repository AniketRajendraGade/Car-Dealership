package com.project.Carss.Services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.Carss.FileStorageproperties;
import com.project.Carss.Dto.AddProductDto;
import com.project.Carss.Repository.ProductRepository;
import com.project.Carss.entities.Product;
import com.project.Carss.exception.StorageException;

@Service
public class productServices {
	
	@Autowired
	public ProductRepository productRepository;
	
	private final Path rootLocation;
	
	
	public productServices(FileStorageproperties fileStorageproperties) {
			this.rootLocation=Paths.get(fileStorageproperties.getUploadDir());
			
			try {
				Files.createDirectories(rootLocation);
			}catch(IOException e){
				throw new StorageException("could not initilize directory");
			}
	}

	
	
	
	
	public String Add(AddProductDto addProductDto, MultipartFile file) {
		Product product =new Product();
		product.setPName(addProductDto.getPName());
		product.setPrice(addProductDto.getPrice());
		product.setDescription(addProductDto.getDescription());
		
		
		Path destinationFile =this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
		try(InputStream inputStream=file.getInputStream()){
			
			Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			throw new StorageException("coudn not save file");
		}
		product.setImageUrl(file.getOriginalFilename());
		
		this.productRepository.save(product);
		
		return "user created";
	}

	
	public List<Product> getAllprod(){
		List<Product> allProducts=this.productRepository.findAll();
		return allProducts;
	}
	
	

}
