<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/css/notice.css">
<script type="text/javascript" src="/script/notice.js"></script>
    <form action="noticeProc" name="topForm1" method="post">
       <table>
       <thead>
          <tr>
             <th colspan="3">공지사항등록</th>
          </tr>
        </thead>
        <tbody>
            <tr>
               <td class="col1">제목</td>
               <td class="col2">
               <input type="text" name="n_subject" class="chk1" title="제목"
                   placeholder="제목을 입력하시오">
               </td>
               <td class="col3">제목을 입력하시오.</td>
            </tr>
            <tr>
               <td class="col1">작성자</td>
               <td class="col2">
               <input type="text" name="n_writer" class="chk1" title="작성자" value="${ssKey.m_name}"
                   placeholder="작성자 이름을 입력하시오.">
               </td>
               <td class="col3">작성자 이름을 입력하시오.</td>
            </tr>
            <tr>
               <td class="col1">내용</td>
               <td class="col2">
                 <textarea class="chk1" rows="10" cols="60" title="공지사항 내용" name="n_content"></textarea>
               </td>
               <td class="col3">내용을 입력하시오</td>
            </tr>
            <tr>
               <td class="col1">공지종료</td>
               <td class="col2">
               <input type="date"  name="n_vdate" class="chk1" title="종료일">  
               </td>
               <td class="col3">공지사항 종료일을 선택하시오</td>
              </tr>
            </tbody>
           <tfoot>
           <tr>
              <td colspan="3">
                 <button class="submit1" type="button">등록</button>
                 <button type="reset">다시쓰기</button>
              </td>
           </tr>
        </tfoot>
       </table>
       <input type="hidden" name="flag" value="insert">
    </form>
