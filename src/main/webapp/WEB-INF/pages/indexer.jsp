   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <div id="Logo" class="logo-absolute">
       <div class="container">
          <span class="logoFont">K<span class="logoNoSize">NO</span><span class="logoDexColor">dex</span></span>
       </div> 
    </div>   
    <div id="Indexer" class="index-absolute">
     <div class="container">
      <!-- Main Index Adder -->
      <div class="jumbotron">
        <%-- Form for getting the Knodex sentences to index by alphabet --%>
         <form:form modelAttribute="knodexForm" action="/Knodex/add/knodexSentenceToIndex" method="post">
			 <div class="input-group input-group-lg">
				<span class="input-group-btn input-group-btn-lg">
					<button class="btn btn-lg btn-primary" type="submit">
					  <span class="glyphicon glyphicon-book"></span>
					   Index it...!
					</button>
				</span> <form:input path="indexSentence" type="text" class="form-control" placeholder="Add Anything to Index"/>
			 </div>
			</form:form>
		   <form:form modelAttribute="knodexForm" action="/Knodex/list/knodexSentenceByIndex" method="post">
              <form:input path="indexBy" type="hidden"/>
			 <!-- /input-group -->
			 <p width="100%" align="center">
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('A')">A</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('B')">B</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('C')">C</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('D')">D</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('E')">E</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('F')">F</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('G')">G</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('H')">H</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('I')">I</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('J')">J</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('K')">K</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('L')">L</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('M')">M</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('N')">N</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('O')">O</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('P')">P</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('Q')">Q</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('R')">R</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('S')">S</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('T')">T</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('U')">U</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('V')">V</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('W')">W</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('X')">X</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('Y')">Y</a></span>
			   <span class="indexpad"><a class="badge" href="javascript: listIndexBy('Z')">Z</a></span>
            </p>
          </form:form>  
      </div>

     </div> <!-- /container -->
    </div>  <!-- /index-fixed -->
