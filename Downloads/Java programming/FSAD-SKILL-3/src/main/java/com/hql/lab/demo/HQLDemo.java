package com.hql.lab.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hql.lab.entity.Product;
import com.hql.lab.loader.ProductDataLoader;
import com.hql.lab.util.HibernateUtil;

public class HQLDemo {

 public static void main(String[] args) {

  SessionFactory factory = HibernateUtil.getSessionFactory();
  Session session = factory.openSession();

  // Insert Data
  ProductDataLoader.loadSampleProducts(session);

  // Sorting ASC
  Query<Product> q1 = session.createQuery("FROM Product ORDER BY price ASC", Product.class);
  List<Product> list1 = q1.list();
  System.out.println("Price Ascending:");
  list1.forEach(System.out::println);

  // Sorting DESC
  Query<Product> q2 = session.createQuery("FROM Product ORDER BY price DESC", Product.class);
  List<Product> list2 = q2.list();
  System.out.println("Price Descending:");
  list2.forEach(System.out::println);

  // Pagination
  Query<Product> q3 = session.createQuery("FROM Product", Product.class);
  q3.setFirstResult(0);
  q3.setMaxResults(3);
  List<Product> list3 = q3.list();
  System.out.println("First 3 Products:");
  list3.forEach(System.out::println);

  // Count
  Query<Long> q4 = session.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
  System.out.println("Total Products: " + q4.uniqueResult());

  // Min Max
  Query<Object[]> q5 = session.createQuery("SELECT MIN(price), MAX(price) FROM Product", Object[].class);
  Object[] result = q5.uniqueResult();
  System.out.println("Min Price: " + result[0]);
  System.out.println("Max Price: " + result[1]);

  // Price Range
  Query<Product> q6 = session.createQuery("FROM Product WHERE price BETWEEN 20 AND 100", Product.class);
  List<Product> list6 = q6.list();
  System.out.println("Price between 20 and 100:");
  list6.forEach(System.out::println);

  // LIKE
  Query<Product> q7 = session.createQuery("FROM Product WHERE name LIKE 'D%'", Product.class);
  List<Product> list7 = q7.list();
  System.out.println("Names starting with D:");
  list7.forEach(System.out::println);

  session.close();
  factory.close();
 }
}