<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content-absolute">
 <div class="container">
   <div class="content-place">
   <c:choose>
     <c:when test="${indexByResults!=null}">
      <c:choose>
    	 <c:when test="${knodexForm.indexBy eq 'All'}">
          hello
        	 <c:forEach var="resultRow" items="${indexByResults}" varStatus="status">
        	    <span class="indexpad"><span class="badge click-badge">${resultRow.key}</span></span><br/>
        	    <table cellpadding="5" cellspacing="0" width="100%">
          		 <tr>
            		  <td width="3%"><span id="${resultRow.key}_${status}" class="glyphicon glyphicon-trash cursor" title="Remove"></span></td>
            		  <td width="24%"><span>${resultRow.value.indexBy}</span></td><td width="3%"> <span class="glyphicon glyphicon-chevron-right"></span></td>
            		  <td width="70%"><span>${resultRow.value.indexSentence}</span></td>
         		 </tr>
         		</table> 
            </c:forEach>
         </c:when>
         <c:otherwise>
            <table cellpadding="5" cellspacing="0" width="100%">
      		  <c:forEach var="resultRow" items="${indexByResults}" varStatus="status">
          		<tr>
              		<td width="3%"><span id="Index_${status}" class="glyphicon glyphicon-trash cursor" title="Remove"></span></td>
              		<td width="24%"><span>${resultRow.indexBy}</span></td><td width="3%"> <span class="glyphicon glyphicon-chevron-right"></span></td>
              		<td width="70%"><span>${resultRow.indexSentence}</span></td>
          		</tr>
        	 </c:forEach>
      		</table>
         </c:otherwise>
       </c:choose>  
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