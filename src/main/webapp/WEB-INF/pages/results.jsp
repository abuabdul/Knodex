<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content-absolute">
 <div class="container">
   <div class="content-place">
   <c:choose>
     <c:when test="${indexByResults!=null}">
      <c:choose>
    	 <c:when test="${knodexForm.indexKey eq 'All'}">
        	 <c:forEach var="resultRow" items="${indexByResults}" varStatus="status">
        	    <span class="indexpad"><span class="badge click-badge">${resultRow.key}</span></span><br/><br/>
        	    <c:forEach var="docObject" items="${resultRow.value}" varStatus="valueStatus">
        	       <table cellpadding="5" cellspacing="0" width="100%">
            		 <tr>
             		   <td width="3%"><span id="${resultRow.key}_${status.count}_${valueStatus.count}_${docObject.id}" class="glyphicon glyphicon-trash cursor" title="Remove"></span></td>
             		   <td width="24%"><span>${docObject.indexBy}</span></td><td width="3%"> <span class="glyphicon glyphicon-chevron-right"></span></td>
            		   <td width="70%"><span>${docObject.indexSentence}</span></td>
             		 </tr>
            		</table>
        	    </c:forEach>
        	    <br/>
            </c:forEach>
         </c:when>
         <c:otherwise>
            <table cellpadding="5" cellspacing="0" width="100%">
      		  <c:forEach var="resultRow" items="${indexByResults}" varStatus="status">
          		<tr>
              		<td width="3%"><span id="Index_${status.count}_${resultRow.id}" class="glyphicon glyphicon-trash cursor" title="Remove"></span></td>
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