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
               <input type="text" name="subject" class="chk1" title="제목"
                   value="${notice.n_subject}">
               </td>
            </tr>
            <tr>
               <td class="col1">작성자</td>
               <td class="col2">
               <input type="text" name="writer" class="chk1" value="${notice.n_writer}">
               </td>
            </tr>
            <tr>
               <td class="col1">내용</td>
               <td class="col2">
                 <textarea class="chk1" rows="10" cols="60" name="content" readonly="readonly">${notice.n_content}</textarea>
               </td>
            </tr>
            <tr>
               <td class="col1">작성일자</td>
               <td class="col2">
               <input type="text"  name="vdate" class="chk1" value="${notice.n_regdate}">  
               </td>
              </tr>
            <tr>
               <td class="col1">공지종료</td>
               <td class="col2">
               <input type="date"  name="vdate" class="chk1" readonly="readonly" value="${notice.n_vdate}">  
               </td>
              </tr>
            </tbody>
           <tfoot>
           <tr>
              <td colspan="3">
                 <button type="button" onclick="location.href='/notice'">공지사항 목록</button>
              </td>
           </tr>
        </tfoot>
       </table>
    </form>