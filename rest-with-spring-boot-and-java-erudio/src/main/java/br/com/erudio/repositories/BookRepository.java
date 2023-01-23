package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.modal.Book;
import br.com.erudio.modal.Person;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	
}
