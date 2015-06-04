/**
 * 
 */
$(function(){
	 $('#list').change(function() {
		 var typeId = $(this).val();
		 $.ajax({
				url : "ajax",
				type : "post",
				data :{"typeId":typeId},
				dataType:"json",
				success : function(data) {
					var length = data.attributes.length;
					for(var i =0; i<length;i++){
						if(i===0)$('.attributes').remove();
						$('#content form').append('<label class="attributes">'+data.attributes[i].attributeName+'</label><input class="attributes" name="'+data.attributes[i].attributeName+'"><br><br>');
					}
					
				},
				error : function(data, status, er) {
					alert("error");
				},

			});

		});

	}); 
		   
