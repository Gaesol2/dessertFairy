<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/css/notice.css">
<script src="/script/Notice.js"></script>
<script src="/jquery/jquery-3.7.0.min.js"></script>
  <div id="nganerate">
    <form action="/noticeProc" name="topForm" method="post">
       <table>
       <thead>
          <tr>
             <th colspan="3">공지사항등록</th>
          </tr>
        </thead>
        <tbody>
            <tr>
               <td class="cl1">제목</td>
               <td class="cl2">
               <input type="text" name="n_subject" class="chk" title="제목"
                   placeholder="제목을 입력하시오">
               </td>
               <td class="cl3">제목을 입력하시오.</td>
            </tr>
            <tr>
               <td class="cl1">작성자</td>
               <td class="cl2">
               <input type="text" name="n_writer" class="chk" title="작성자" value="${ssKey.m_name}"
                   placeholder="작성자 이름을 입력하시오.">
               </td>
               <td class="cl3">작성자 이름을 입력하시오.</td>
            </tr>
            <tr>
               <td class="cl1">내용</td>
               <td class="cl2">
                 <textarea class="chk" rows="10" cols="60" title="공지사항 내용" name="n_content"></textarea>
               </td>
               <td class="cl3">내용을 입력하시오</td>
            </tr>
            <tr>
               <td class="cl1">공지종료</td>
               <td class="cl2">
               <input type="date"  name="n_vdate" class="chk" title="종료일">  
               </td>
               <td class="cl3">공지사항 종료일을 선택하시오</td>
              </tr>
            </tbody>
           <tfoot>
           <tr>
              <td colspan="3">
                 <button class="noticeBtn" type="submit">공지사항 등록</button>
                 <button type="reset">다시쓰기</button>
                 <button type="button" onclick="location.href='notice'">공지사항 목록</button>
              </td>
           </tr>
        </tfoot>
       </table>
       <input type="hidden" name="flag" value="insert">
    </form>
  </div>
