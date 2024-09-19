package com.spring_boot_mybatis_book.project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis_book.project.model.BookVO;

//dao 추상 메소드는 service 추상메소드와 일치
//dao 인터페이스 구현은 mapper에서 진행
public interface IBookDAO {
	
	public ArrayList<BookVO> listAllBook(); //read(select * from book:여러권에대한 정보)
	public void insertBook(BookVO vo); //create(insert : 책 1권에대한 정보 저장)
	public void updateBook(BookVO vo); //update(update)
	public void deleteBook(String bookNo); //delete(delete : 책 1권 레코드 삭제(특정 책을 구분할 수 있는 정보(기본키)가 있어야 1권만 삭제가 됨)
	public BookVO detailViewBook(String bookNo); //read(select * from book where bookNo="xxx" : bookNo xxx책에 대한 정보가 반환)
	public String bookNoCheck(String bookNo); //도서번호 중복 확인 
	public ArrayList<BookVO> bookSearch(HashMap<String,Object> param);//도서 검색
}
