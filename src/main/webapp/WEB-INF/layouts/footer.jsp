<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

  <tiles:insertAttribute name="knodexContent"/>

    <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.poshytip.js"/>"></script>
    
    <script type="text/javascript">
      $(document).ready(function () {
    	  
    	  var isAnimated = false;
    	  
    	  $(window).scroll(function () {
    		  if($(this).scrollTop() > 55 && !isAnimated){
    			  $('#Logo').removeClass('logo-absolute');
    			  $('#Indexer').removeClass('index-absolute');
    			  $('#Logo,#Indexer').hide();
    			  $('#Logo').addClass('logo-fixed');
    			  $('#Indexer').addClass('index-fixed');
    			  $("div.jumbotron").addClass('border-jump');
    			  $('#Logo,#Indexer').slideDown(900);
    			  isAnimated = true;
    		  }
    		  if($(this).scrollTop() == 0 && isAnimated){
    			  $('#Logo').removeClass('logo-fixed');
    			  $('#Logo').addClass('logo-absolute');
    			  $('#Indexer').removeClass('index-fixed');
    			  $("div.jumbotron").removeClass('border-jump');
    			  $('#Indexer').addClass('index-absolute');
    			  isAnimated = false;
    		  }
    	  });
    	  
    	  var _aboutKnodexMsg = $("#AboutKnodex").html();
    	  
    	  $("#AboutMsg").poshytip({
    		  content: _aboutKnodexMsg,
    		  className: 'tip-knodexblue',
    		  showOn: 'none',
    		  alignTo: 'target',
    	      alignX: 'left',
    		  offsetX: 0,
      		  offsetY: 3,
      		  fade: true
    	  });
    	  
    	  $(document).click(function(e){
    		  if(e.target.id != 'AboutMsg'){
    		    $("#AboutMsg").poshytip('hide');
    		  }
    	  });
    	  
    	  $("#AboutMsg").click(function(){
    		  $(this).poshytip('show');
    	  });
    	  
    	  $("#KnodexLogo").click(function(){
    		 window.location.href="/Knodex/"; 
    	  });
    	  
    	  $("span.badge").mouseover(function(e){
    		  if($("#indexKey").val() != e.target.id){
    		   $("#"+e.target.id).addClass("click-badge");
    	      }
    	  });
    	  
    	  $("span.badge").mouseout(function(e){
    		  if($("#indexKey").val() != e.target.id){
    		   $("#"+e.target.id).removeClass("click-badge");
    		  }
    	  });
    	  
    	  $("span.badge").click(function(e){
        	  $("#indexKey").val(e.target.id);
        	  $("#knodexForm").attr("action","/Knodex/list/knodexSentenceByIndex");
        	  $("#knodexForm").submit();
    	  });
    	  
    	  $("#ViewAllEye").mouseover(function(){
    		  if($("#indexKey").val() != 'All'){
    		   $(this).addClass("click-eye-selected");
    		  }
    	  });
    	  
    	  $("#ViewAllEye").mouseout(function(){
    		  if($("#indexKey").val() != 'All'){
    		   $(this).removeClass("click-eye-selected");
    		  } 
    	  });
    	  
    	  $("#ViewAllEye").click(function(){
    		  $("#indexKey").val('All');
         	  $("#knodexForm").attr("action","/Knodex/list/all/knodexSentenceByIndex");
        	  $("#knodexForm").submit();
    	  });
    	  
    	  //Display and fade out the success message
    	  var successFlag = '<c:out value="${operation}"/>';
    	  if(successFlag == 'true'){
    		  $("div.success-absolute").removeClass("hidden");
    		  $("div.success-absolute").fadeOut(3000);
    	  }
    	  
    	  $("span.glyphicon-trash").click(function(){
    		  var idTrash = this.id;
    		  $.post("/Knodex/remove/knodexSentenceToIndex",  { knodexId : this.id }, function(data) {
    			  if(data){
    				  $("#Tr_"+idTrash).fadeOut(750);
    				  var countIndex = parseInt($("#totalIndex").html().trim());
    				  countIndex = countIndex -1;
    				  if(countIndex > 0){
    					  $("#totalIndex").html(countIndex);
    				  }else{
    					  $("#ResultPane").html('<table cellpadding="5" cellspacing="0" width="100%"><tr><td width="100%" align="center">You don\'t have anything indexed yet!!!</td></tr></table>');
    				  }
    			  }
    		  });
    	  });
      });
            
    </script>