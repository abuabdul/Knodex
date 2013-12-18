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
    		  if($(this).scrollTop() > 280 && !isAnimated){
    			  $('#Logo').removeClass('logo-absolute');
    			  $('#Indexer').removeClass('index-absolute');
    			  $('#Logo,#Indexer').hide();
    			  $('#Logo').addClass('logo-fixed');
    			  $('#Indexer').addClass('index-fixed');
    			  $('#Logo,#Indexer').slideDown(900);
    			  isAnimated = true;
    		  }
    		  if($(this).scrollTop() == 0 && isAnimated){
    			  $('#Logo').removeClass('logo-fixed');
    			  $('#Logo').addClass('logo-absolute');
    			  $('#Indexer').removeClass('index-fixed');
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
    	  }) 
      });
      
    </script>