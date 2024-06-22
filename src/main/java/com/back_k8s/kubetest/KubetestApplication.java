package com.back_k8s.kubetest;

import com.back_k8s.kubetest.domain.model.BookEntity;
import com.back_k8s.kubetest.infrastructure.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class KubetestApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(KubetestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<BookEntity> bookEntities = Arrays.asList(
				BookEntity.builder().name("Book 1").description("Description of Book 1").stock(100).stockAvailable(100).author("Author 1").price(29.99).build(),
				BookEntity.builder().name("Book 2").description("Description of Book 2").stock(150).stockAvailable(150).author("Author 2").price(39.99).build(),
				BookEntity.builder().name("Book 3").description("Description of Book 3").stock(80).stockAvailable(80).author("Author 3").price(19.99).build(),
				BookEntity.builder().name("Book 4").description("Description of Book 4").stock(120).stockAvailable(120).author("Author 4").price(49.99).build(),
				BookEntity.builder().name("Book 5").description("Description of Book 5").stock(200).stockAvailable(200).author("Author 5").price(24.99).build(),
				BookEntity.builder().name("Book 6").description("Description of Book 6").stock(90).stockAvailable(90).author("Author 6").price(34.99).build(),
				BookEntity.builder().name("Book 7").description("Description of Book 7").stock(110).stockAvailable(110).author("Author 7").price(44.99).build(),
				BookEntity.builder().name("Book 8").description("Description of Book 8").stock(70).stockAvailable(70).author("Author 8").price(14.99).build(),
				BookEntity.builder().name("Book 9").description("Description of Book 9").stock(180).stockAvailable(180).author("Author 9").price(54.99).build(),
				BookEntity.builder().name("Book 10").description("Description of Book 10").stock(60).stockAvailable(60).author("Author 10").price(39.99).build()
		);

		bookRepository.saveAll(bookEntities);
	}

	@Autowired
	public KubetestApplication(BookRepository bookRepository){
		this.bookRepository=bookRepository;
	}

}
