package com.spring_boot_mybatis_book.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis_book.project.model.BookVO;
import com.spring_boot_mybatis_book.project.service.BookService;

@Controller
public class BookController {
	//객체(service) 변수 선언, 생성은 자동 주입
	@Autowired
	BookService bookService;
	
	@RequestMapping("/")
	public String viewPage() {
		return "index";
	}
	
	//아래 요청이 들어오면 service로 전체 도서정보 조회와 관련된 메소드 호출 : 반환 결과 view로 전달
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		 ArrayList<BookVO> bookList= bookService.listAllBook();
		 model.addAttribute("bookList",bookList);
		 return "book/bookListView"; //view 페이지 결정
	}
	
	//새로운 도서 정보 등록폼 요청에 대해 처리 메소드 : 도서정보 등록 폼만 반환
	@RequestMapping("/book/newBookForm")
	public String newBookForm() {
		return "book/newBookForm";
	}
	
	//클라이언트가 전송된 form data(새로운 책 1권에 대한 정보->model.BookVO에 파라미터값 받기)
	//전달된 파라미터 command객체로 받기 : command 객체는 BookVO 클래스 -> 파라미터로 전달된 값들이 BookVO 클래스 필드에 저장
	//input태그 name 속성값과 vo클래스 필드명이 동일해야 함
	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO vo){
		//서비스의 관련 메소드 호출하면서 파라미터값이 저장된 객체 변수 vo를 전달
		bookService.insertBook(vo); //반환값은 없으므로 저장 필요 없음
		return "redirect:/book/listAllBook";//전체 도서정보조회 기능으로 redirect
	}
	
	//도서 상세 정보 페이지로 이동
	@RequestMapping("/book/detailViewBook/{bookNo}")
	public String detailViewBook(@PathVariable String bookNo,Model model) {
		//service 관련 메소드 호출 : 도서번호 전달하고 해당 도서정보 반환받기
		BookVO vo = bookService.detailViewBook(bookNo);
		model.addAttribute("vo",vo);
		
		return "book/bookDetailView" ; //도서 상세 정보 뷰 페이지 결정
	}
	
	//도서 정보 수정 폼페이지 요청 처리 메소드 : 전달된 bookNo 이용해서 상세정보와 동일하게 특정 도서 정보 반환 받은 후 input form에 전달
	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo,Model model) {
		//service의 관련 메소드 호출(수정페이지에 기존에 입력했던 값 표시 : 특정 도서에대한 상세정보가 필요)
		BookVO book = bookService.detailViewBook(bookNo);
		model.addAttribute("book",book);
		return "book/updateBookForm";
	}
	
	//도서 정보 수정 db 저장 처리 메소드
	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO vo) {
		bookService.updateBook(vo);
		
		return "redirect:/book/listAllBook";
	}
	
	//특정 도서 정보 삭제 처리 메소드
	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		bookService.deleteBook(bookNo);
		return "redirect:/book/listAllBook";
	}
	
	//도서번호 중복 확인 : ajax 요청이므로 데이터 그대로 ajax로 전송
	@ResponseBody
	@RequestMapping("/book/bookNoCheck") // book/book/bookNoCheck
	public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		
		String res = "available";
		
		if(bookNo_res != null) { //도서번호가 있음
			res="not-available";
		}
		return res; //String형 데이터가 클라이언트에게 전달
		}
	
	// /book/book/bookNoCheck1/1001	
	//도서번호 중복 확인2 : ajax 요청이므로 데이터 그대로 ajax로 전송
	//ajax get 방식 요청
	@ResponseBody
	@RequestMapping("/book/bookNoCheck1/{bookNo}") // /book/book/bookNoCheck1/1001	
	public String bookNoCheck1(@PathVariable("bookNo") String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		
		String res = "available";
		
		if(bookNo_res != null) { //도서번호가 있음
			res="not-available";
		}
		return res; //String형 데이터가 클라이언트(ajax())에게 전달
		}	
	
	///book/booNoCheck2/1001 요청을 처리하는 메소드
	//도서번호 중복 확인3 : fetch()요청이므로 데이터 그대로 fech()로 전송
	//get 방식 요청
	@ResponseBody
	@RequestMapping("/book/bookNoCheck2/{bookNo}") // /book/book/bookNoCheck2/1001	
	public String bookNoCheck2(@PathVariable("bookNo") String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		System.out.println(bookNo_res);
		String res = "available";
		
		if(bookNo_res != null) { //도서번호가 있음
			res="not-available";
		}
		return res; //String형 데이터가 클라이언트(fetch())에게 전달
		} 
	
	///book/booNoCheck3 요청을 처리하는 메소드
	//도서번호 중복 확인4 : fetch()요청이므로 데이터 그대로 fetch()로 전송
	//post 방식 요청
	@ResponseBody
	@RequestMapping("/book/bookNoCheck3")
	public String bookNoCheck3(@RequestBody String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		System.out.println(bookNo_res);
		String res = "available";
		
		if(bookNo_res != null) { //도서번호가 있음
			res="not-available";
		}
		return res; //String형 데이터가 클라이언트(fetch())에게 전달
		}
	
	//도서번호 중복 확인5 : axios()요청이므로 데이터 그대로 axios()로 전송
	//get 방식 요청
	@ResponseBody
	@RequestMapping("/book/bookNoCheck4/{bookNo}") // /book/book/bookNoCheck2/1001	
	public String bookNoCheck4(@PathVariable("bookNo") String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		System.out.println(bookNo_res);
		String res = "available";
		
		if(bookNo_res != null) { //도서번호가 있음
			res="not-available";
		}
		return res; //String형 데이터가 클라이언트(axios())에게 전달
		} 	
	
	///book/bookNoCheck5
	//도서번호 중복 확인5 : axios()요청이므로 데이터 그대로 axios()로 전송
	//post 방식 요청
	@ResponseBody
	@RequestMapping("/book/bookNoCheck5")
	public String bookNoCheck5(@RequestBody HashMap<String, String> map) {
		String bookNo_res = bookService.bookNoCheck(map.get("bookNo"));
		System.out.println(bookNo_res);
		String res = "available";
		
		if(bookNo_res != null) { //도서번호가 있음
			res="not-available";
		}
		return res; //String형 데이터가 클라이언트(fetch())에게 전달
		}	
	
	//도서검색 1
	//도서 검색 폼 열기 요청 처리 메소드(1번 방법의 폼) : index.jsp에서 요청
	@RequestMapping("/book/bookSearchForm1")
	public String viewBookSearchForm1() {
		return "book/bookSearchForm1";
	}
	
	//도서 검색 폼에서 검색 조건 입력후 ajax에 의해서 요청이 일어남(ajax 비동기 통신 요청 처리 후 응답도 ajax로 반환, 처리 후 결과 데이터 그대로 반환)
	@ResponseBody //처리 결과 그대로 반환(view반환하지 않음, 객체 그대로 반환)
	@RequestMapping("/book/bookSearch1")
	public ArrayList<BookVO> bookSearch1(@RequestParam HashMap<String, Object> param, Model model){
		//dbms와 통신해야하는 비즈니스로직인 경우에는 컨트롤러가 해결하지 않음 ->서비스->dao
		ArrayList<BookVO> bookList = bookService.bookSearch(param);
		model.addAttribute("bookList",bookList);
		
		return bookList; //ArrayList<BookVO> 타입의 객체가 반환, ArrayList는 http 변환 불가하기 때문에 관련 의존성이 추가 되어 있어야 함(jackson-databind)
		
	}
	
	
	//도서검색 2
	//도서 검색 폼 열기 요청 처리 메소드(2번 방법의 폼) : index.jsp에서 요청
	@RequestMapping("/book/bookSearchForm2")
	public String viewBookSearchForm2() {
		return "book/bookSearchForm1";
	}
	
	//도서 검색 폼에서 검색 조건 입력후 ajax에 의해서 요청이 일어남(ajax 비동기 통신 요청 처리 후 응답도 ajax로 반환, 
	//처리 후 결과 데이터 담고있는 jsp view 페이지 반환)
	//@ResponseBody //처리 결과 view페이지로 반환 하므로 해당 어노테이션 사용하지 않음
	@RequestMapping("/book/bookSearch2")
	public String bookSearch2(@RequestParam HashMap<String, Object> param, Model model){
		//dbms와 통신해야하는 비즈니스로직인 경우에는 컨트롤러가 해결하지 않음 ->서비스->dao
		ArrayList<BookVO> bookList = bookService.bookSearch(param);
		model.addAttribute("bookList",bookList);
		
		return "book/bookSearchResultView"; //View 페이지 결정
		
	}	
	}








