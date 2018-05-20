/**
 * 
 */
package com.nagarro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */

@Repository("customerRepository")
public class CustomerRepositoryImpl {

	@Autowired
	private HibernateUtil hibernateUtil;
}
