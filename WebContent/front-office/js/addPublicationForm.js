$(function () {

	// Load type attributes

	$('select[name="type"]').change(function() {
		$('#content form').attr('data-form', 'not-sendable');
		$('#content .type-attributes').html('<div class="loader col-sm-10 col-md-offset-2 text-center"><i class="fa fa-spinner fa-pulse fa-3x"></i></div>');

		$.ajax({
			type: 'POST',
			dataType: 'json',
			data: {
				'typeId' : $(this).val()
			},
			url: 'ajax',
			success: function(data) {
				$('#content .type-attributes').html('');

				for(var i = 0, n = data.attributes.length ; i < n ; i++) {
					$('#content .type-attributes').append('<div class="form-group"><label for="label-' + data.attributes[i].attributeName + '" class="col-sm-2 control-label">' + data.attributes[i].attributeName + ' *</label><div class="col-sm-10"><input type="text" class="form-control" name="attribute'+data.attributes[i].attributeId+ '" id="label-' + data.attributes[i].attributeName + '" data-rule-required="true"></div></div>');
				}

				$('#content form').attr('data-form', 'sendable');
			}
		});
	});

});