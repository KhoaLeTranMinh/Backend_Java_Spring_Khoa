package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Interfaces.BookingRepository;
import com.example.demo.Interfaces.BookingRepositoryCustom;
import com.example.demo.Interfaces.RoomRepository;
import com.example.demo.Models.Booking;
import com.example.demo.Models.Room;
import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	@Autowired
	private static BookingRepository bookingRepository;

	@Autowired
	private static RoomRepository roomRepository;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class, args);
		// SpringApplication.run(AccessingDataJpaApplication.class);
		bookingRepository = context.getBean(BookingRepository.class);
		roomRepository = context.getBean(RoomRepository.class);
		Room room = new Room("Luxury", true);
		roomRepository.save(room);
		long roomId = room.getId();

		List<Thread> allThreads = new ArrayList<Thread>();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				bookingRepository.setABooking(roomId);
			}

		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				bookingRepository.setABooking(roomId);
			}

		});
		thread1.start();
		allThreads.add(thread1);

		thread2.start();
		allThreads.add(thread2);

		for (Thread t : allThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		log.info("Before booking");
		log.info(room.toString());

		log.info("Room status");
		Room bookedRoom = roomRepository.findById(roomId);

		log.info("Room found with findById(roomId) after booking:");
		log.info(bookedRoom.toString());

		log.info("Room status");
		log.info("All rooms found with findAll: ");
		roomRepository.findAll().forEach(foundRoom -> log.info(foundRoom.toString()));

		log.info("Booking status");
		log.info("All bookings found with findAll: ");
		bookingRepository.findAll().forEach(booking -> log.info(booking.toString()));
		// @Bean
		// public CommandLineRunner demo(RoomRepository roomRepository,
		// BookingRepository bookingRepository) {
		// return (args) -> {
		// // save a few customers
		// // repository.save(new Customer("Jack", "Bauer"));
		// // repository.save(new Customer("Chloe", "O'Brian"));
		// // repository.save(new Customer("Kim", "Bauer"));
		// // repository.save(new Customer("David", "Palmer"));
		// // repository.save(new Customer("Michelle", "Dessler"));
		// // Room room = new Room("Luxury", true);
		// // roomRepository.save(room);
		// // log.info("Before booking");
		// // log.info(room.toString());
		// // long roomId = room.getId();

		// // List<Thread> allThreads = new ArrayList<Thread>();
		// // Thread thread1 = new Thread(new Runnable() {
		// // @Override
		// // public void run() {
		// // bookingRepository.setABooking(roomId);
		// // }

		// // });
		// // thread1.start();
		// // allThreads.add(thread1);
		// // Thread thread2 = new Thread(new Runnable() {
		// // @Override
		// // public void run() {
		// // bookingRepository.setABooking(roomId);
		// // }

		// // });
		// // thread2.start();
		// // allThreads.add(thread2);

		// // for (Thread t : allThreads) {
		// // t.join();
		// // }

		// // log.info("Room status");
		// // Room bookedRoom = roomRepository.findById(roomId);

		// // log.info("Room found with findById(roomId) after booking:");
		// // log.info("--------------------------------");
		// // log.info(bookedRoom.toString());
		// // log.info("");

		// // log.info("Booking status");
		// // log.info("All bookings found with findAll: ");
		// // bookingRepository.findAll().forEach(booking ->
		// log.info(booking.toString()));

		// // // fetch all customers
		// // log.info("Customers found with findAll():");
		// // log.info("-------------------------------");
		// // repository.findAll().forEach(customer -> {
		// // log.info(customer.toString());
		// // });
		// // log.info("");

		// // // fetch an individual customer by ID
		// // Customer customer = repository.findById(1);
		// // log.info("Customer found with findById(1):");
		// // log.info("--------------------------------");
		// // log.info(customer.toString());
		// // log.info("");

		// // // fetch customers by last name
		// // log.info("Customer found with findByLastName('Bauer'):");
		// // log.info("--------------------------------------------");
		// // repository.findByLastName("Bauer").forEach(bauer -> {
		// // log.info(bauer.toString());
		// // });
		// // log.info("");
		// };
		// }

	}
}