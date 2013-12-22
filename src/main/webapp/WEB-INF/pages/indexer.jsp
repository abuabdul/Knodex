   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <div id="Logo" class="logo-absolute">
       <div class="container">
          <span id="KnodexLogo" class="cursor"><span class="logoFont">K<span class="logoNoSize">NO</span><span class="logoDexColor">dex</span></span></span>
       </div> 
    </div>   
    
    <div id="Indexer" class="index-absolute">
     <div class="container">
      <!-- Main Index Adder -->
      <div class="jumbotron">
        <%-- Form for getting the Knodex sentences to index by alphabet --%>
         <form:form modelAttribute="knodexForm" action="/Knodex/add/knodexSentenceToIndex" method="post">
            <form:input path="indexBy" type="hidden"/>
			 <div class="input-group input-group-lg">
				<span class="input-group-btn input-group-btn-lg">
					<button class="btn btn-lg btn-primary" type="submit">
					  <span class="glyphicon glyphicon-book"></span>
					   Index it...!
					</button>
				</span> <form:input path="indexSentence" type="text" class="form-control" placeholder="Add Anything to Index"/>
			 </div>
			 <!-- /input-group -->
			 <p width="100%" align="center">
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'A'}">click-badge</c:if>" id="A">A</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'B'}">click-badge</c:if>" id="B">B</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'C'}">click-badge</c:if>" id="C">C</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'D'}">click-badge</c:if>" id="D">D</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'E'}">click-badge</c:if>" id="E">E</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'F'}">click-badge</c:if>" id="F">F</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'G'}">click-badge</c:if>" id="G">G</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'H'}">click-badge</c:if>" id="H">H</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'I'}">click-badge</c:if>" id="I">I</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'J'}">click-badge</c:if>" id="J">J</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'K'}">click-badge</c:if>" id="K">K</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'L'}">click-badge</c:if>" id="L">L</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'M'}">click-badge</c:if>" id="M">M</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'N'}">click-badge</c:if>" id="N">N</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'O'}">click-badge</c:if>" id="O">O</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'P'}">click-badge</c:if>" id="P">P</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'Q'}">click-badge</c:if>" id="Q">Q</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'R'}">click-badge</c:if>" id="R">R</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'S'}">click-badge</c:if>" id="S">S</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'T'}">click-badge</c:if>" id="T">T</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'U'}">click-badge</c:if>" id="U">U</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'V'}">click-badge</c:if>" id="V">V</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'W'}">click-badge</c:if>" id="W">W</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'X'}">click-badge</c:if>" id="X">X</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'Y'}">click-badge</c:if>" id="Y">Y</span></span>
			   <span class="indexpad"><span class="badge <c:if test="${knodexForm.indexBy eq 'Z'}">click-badge</c:if>" id="Z">Z</span></span>
			   <span class="pull-right padding25pxTop"><span id="ViewAllEye" title="View All" class="glyphicon glyphicon-eye-open content-font cursor <c:if test="${knodexForm.indexBy eq 'All'}">click-eye</c:if>"></span></span>
            </p>
          </form:form>  
      </div>

     </div> <!-- /container -->
    </div>  <!-- /index-fixed -->
    <c:if test="${operation}">
     <div id="SuccessMsgDiv" class="success-absolute hidden">
        <div class="container" align="center">
          <div class="alert alert-success success-transparency">
             <p>New Sentence indexed!</p>
          </div>
        </div>    
     </div>
    </c:if>
    
