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
    	  
    	  $(window).scroll(function () {
    		  if($(this).scrollTop() > 55){
    			  $('#Logo').removeClass('logo-absolute');
    			  $('#Logo').addClass('logo-fixed');
    			  $('#Indexer').removeClass('index-absolute');
    			  $('#Indexer').addClass('index-fixed');
    		  }
    		  if($(this).scrollTop() == 0){
    			  $('#Logo').removeClass('logo-fixed');
    			  $('#Logo').addClass('logo-absolute');
    			  $('#Indexer').removeClass('index-fixed');
    			  $('#Indexer').addClass('index-absolute');
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