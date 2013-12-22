<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content-absolute">
 <div class="container">
   <div class="content-place">
     <%-- <span class="indexpad"><span class="badge click-badge">A</span></span><br/> --%>
   <c:choose>
     <c:when test="${indexByResults!=null}">
      <table cellpadding="5" cellspacing="0" width="100%">
        <c:forEach var="resultRow" items="${indexByResults}">
          <tr>
              <td width="3%"><span class="glyphicon glyphicon-remove-circle cursor"></span></td>
              <td width="24%"><span>${resultRow.indexBy}</span></td><td width="3%"> <span class="glyphicon glyphicon-chevron-right"></span></td>
              <td width="70%"><span>${resultRow.indexSentence}</span></td>
          </tr>
        </c:forEach>
      </table>
    </c:when> 
    <c:otherwise>
        <table cellpadding="5" cellspacing="0" width="100%">
          <tr>
            <td width="100%" align="center">You don't have anything indexed yet!!!</td>
          </tr>
        </table>
    </c:otherwise>
   </c:choose> 
  </div>
 </div>
</div> 