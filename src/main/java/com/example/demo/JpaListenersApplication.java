package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan
public class JpaListenersApplication implements ApplicationRunner{
@Autowired
EntityManagerFactory entityManagerFactory;
	public static void main(String[] args) {
		SpringApplication.run(JpaListenersApplication.class, args);		
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		/*EntityTransaction transaction= entityManager.getTransaction();
		transaction.begin();
		Article article=new Article();
		article.setAuthor("KJ");
		article.setTitle("Java");
		entityManager.persist(article);
		transaction.commit();
		System.out.println(article);*/
		Article article2=entityManager.find(Article.class, 3);
		
		article2.setTitle("Kava");
		EntityTransaction transaction= entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(article2);
		transaction.commit();
		
	}
	

}

