package com.spring_boot_mybatis_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis_book.project.dao.IBookDAO;
import com.spring_boot_mybatis_book.project.model.BookVO;
//service 기능을 하는 클래스로 등록
@Service
public class BookService implements IBookService{
	
	//dao 객체 변수 선언 : interface만 있음 구현 클래스는 mapper가 담당
	//생성은 DI 사용, interface이므로 @Qualifier도 사용해야 함
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;

	@Override
	public ArrayList<BookVO> listAllBook() {
		// service는 controll의 호출을 받아 dao를 호출해주는 작업을 함(전달한 매개변수가 있다면 매개변수 전달하고 dao로부터 받은 데이터는 controller에게 return)
		return dao.listAllBook(); //dao 관련 메소드 호출 후 반환결과를 그대로 controller에게 return
	}

	@Override
	public void insertBook(BookVO vo) {
		// 1권의 새 책 정보 db에 저장, dao의 동일 메서드 호출(컨트롤러에게 전달받은 VO 객체 참조값 dao에게 그대로 전달)
		dao.insertBook(vo);
	}

	@Override
	public void updateBook(BookVO vo) {
		// 책정보 수정, dao의 관련 메소드 호출(매개변수로 받은 참조값 dao에 전달)
		dao.updateBook(vo);
		
	}

	@Override
	public void deleteBook(String bookNo) {
		// 특정 도서 정보 삭제 메소드, dao의 동일 메소드 호출(도서번호 전달)
		dao.deleteBook(bookNo);
		
	}

	@Override
	public BookVO detailViewBook(String bookNo) {
		// 도서정보 상세 페이지 관련 서비스 메소드 dao의 관련 메소드 호출 및 매개변수 전달하고 반환값 컨트롤러로 리턴
		return dao.detailViewBook(bookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		// dao 관련 메서드 호출 후 반환값 컨트롤러로 반환
		return dao.bookNoCheck(bookNo);
	}

	@Override
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> param) {
		// dao의 검색 관련 메소드 호출 반환 결과 컨트롤러에 전달
		return dao.bookSearch(param);
	} 
	
	
	
}
