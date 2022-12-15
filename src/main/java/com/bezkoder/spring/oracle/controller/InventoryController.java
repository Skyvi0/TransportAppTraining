package com.bezkoder.spring.oracle.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.oracle.model.Inventory;
import com.bezkoder.spring.oracle.repository.InventoryRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InventoryController {

	@Autowired
	InventoryRepository inventoryRepository;

	@GetMapping("/inventory")
	public ResponseEntity<List<Inventory>> getAllInventoryItems(@RequestParam(required = false) String name) {
		try {
			List<Inventory> inventory = new ArrayList<Inventory>();

			if (name == null)
				inventoryRepository.findAll().forEach(inventory::add);
			else
				inventoryRepository.findByNameContaining(name).forEach(inventory::add);

			if (inventory.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(inventory, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/inventory/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") long id) {
		Optional<Inventory> inventoryData = inventoryRepository.findById(id);

		if (inventoryData.isPresent()) {
			return new ResponseEntity<>(inventoryData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/inventory")
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory item) {
		try {
			Inventory _item = inventoryRepository
					.save(new Inventory());
			return new ResponseEntity<>(_item, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/inventory/{id}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable("id") long id, @RequestBody Inventory item) {
		Optional<Inventory> tutorialData = inventoryRepository.findById(id);

		if (tutorialData.isPresent()) {
			Inventory _item = tutorialData.get();
			_item.setName(item.getName());
			_item.setGewicht(item.getGewicht());
			return new ResponseEntity<>(inventoryRepository.save(_item), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/inventory/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			inventoryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/inventory")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			inventoryRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
