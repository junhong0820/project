package com.spring_boot_mybatis_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis_book.project.model.BookVO;

public interface IBookService {
	//model BookVo 클래스가 DB 데이터(레코드, 테이블 행) 기본 저장 단위, 매개변수나 반환 데이터 타입에서 사용
	//CRUD 기능 구성
	public ArrayList<BookVO> listAllBook(); //read(select * from book:여러권에대한 정보)
	public void insertBook(BookVO vo); //create(insert : 책 1권에대한 정보 저장)
	public void updateBook(BookVO vo); //update(update)
	public void deleteBook(String bookNo); //delete(delete : 책 1권 레코드 삭제(특정 책을 구분할 수 있는 정보(기본키)가 있어야 1권만 삭제가 됨)
	public BookVO detailViewBook(String bookNo); //read(select * from book where bookNo="xxx" : bookNo xxx책에 대한 정보가 반환)
	public String bookNoCheck(String bookNo);
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> param);//도서 검색
}
