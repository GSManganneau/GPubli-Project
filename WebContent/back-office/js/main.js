$(function() {
	// Active boostrap tooltips

	$('[data-toggle="tooltip"]').tooltip();




	// Use of stupidtable

	var sortingTable = $('table').stupidtable();

	sortingTable.on('aftertablesort', function (event, data) {
		$(this).find('th.sort-active').removeClass('sort-active').find('i').removeClass().addClass('fa fa-sort');

		var dir = $.fn.stupidtable.dir;
		var arrow = data.direction === dir.ASC ? 'asc' : 'desc';

		$(this).find('th').eq(data.column).addClass('sort-active').find('i').removeClass().addClass('fa fa-sort-' + arrow);
	});
	
	$('table').find('th').eq(0).stupidsort();




	// Use of fonawesome-iconpicker

	$('.icp-dd').iconpicker();

	$('.icp-dd').on('iconpickerSelected', function(e) {
		$(this).parent().find('input[name="icon"]').attr('value', e.iconpickerValue);
	});




	// Definition and use selectize elements

	$('select.selectize-select-simple').selectize();

	$('select.selectize-select-simple-create').selectize({
		persist: false,
		create: true,
		render: {
			option_create: function (data, escape) {
				return '<div class="create">Ajouter <strong>' + escape(data.input) + '</strong>&hellip;</div>';
			}
		},
		create: function (input) {
			if (/^[0-9a-zA-ZÀ-ÿ]/i.test(input)) {
				return {
					value: '[new]' + input,
					text: input
				};
			} else {
				alert('La valeur entrée est invalide...');
				return false;
			}
			
		}
	});




	// jQuery validation (forms)

	$('.selectize-control .selectize-input input').blur(function () {
		$(this).closest('.form-group').find('select').blur();
	});

	$('form[data-toggle="validator"]').validate({
		submitHandler: function(form) {
			if (!($(form).attr('data-form') == 'not-sendable')) {
				form.submit();
			}
		},
		ignore: ':hidden:not([class~=selectized]),:hidden > .selectized, .selectize-control .selectize-input input',
		highlight: function (element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight: function (element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement: 'span',
		errorClass: 'help-block',
		errorPlacement: function (error, element) {
			if(element.parent('.input-group').length) {
				element.parent().parent().append(error);
			} else {
				element.parent().append(error);
			}
		}
	});

	$('form[data-toggle="validator-form"]').validate({
		ignore: ':hidden:not([class~=selectized]),:hidden > .selectized, .selectize-control .selectize-input input',
		highlight: function (element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight: function (element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorPlacement: function (error, element) {
			return true;
		},
		focusInvalid: false
	});




	// Table alterable

	$('form[data-toggle="validator-form"] table td a.update').click(function (event) {
		event.preventDefault();

		var that = $(this);
		that.closest('form').find('[type="submit"]').closest('.panel-body').show();
		that.closest('table').addClass('table-alterable');
		that.closest('tr').addClass('alterable');


		$('th[data-alterable-type="id"]').each(function () {
			var index = $(this).index();
			var td = that.closest('tr').find('td:nth-child(' + (index + 1) + ')');
			td.append('<input type="text" class="form-control" style="display: none;" value="' + td.text() + '" name="' + $(this).attr('data-alterable-name') + '[]" readonly>');
		});


		$('th[data-alterable-type="input"]').each(function () {
			var index = $(this).index();
			var td = that.closest('tr').find('td:nth-child(' + (index + 1) + ')');

			var validate = $(this).attr('data-alterable-validate').split(' ');
			var dataValidate = '';

			for (var i = 0, n = validate.length ; i < n ; i++) {
				dataValidate += ' data-rule-' + validate[i] + '="true"';
			}

			td.html('<div class="form-group"><input type="text" class="form-control" value="' + td.text() + '" name="' + $(this).attr('data-alterable-name') + '[]"' + dataValidate + '></div>');
		});


		$('th[data-alterable-type="icon"]').each(function () {
			var index = $(this).index();
			var td = that.closest('tr').find('td:nth-child(' + (index + 1) + ')');

			var icon = td.find('i').attr('class').split(' ')[1];
			td.html('<div class="input-group"><div class="btn-group"><button type="button" class="btn btn-default iconpicker-component" disabled><i class="fa ' + icon + '"></i></button><button type="button" class="icp icp-dd btn btn-default dropdown-toggle" data-selected="' + icon + '" data-toggle="dropdown"><span class="caret"></span><span class="sr-only">Toggle Dropdown</span></button><div class="dropdown-menu"></div><input type="text" name="' + $(this).attr('data-alterable-name') + '[]" value="' + icon + '" style="display: none;"></div></div>');
			
			var iconButton = td.find('.icp-dd');
			iconButton.iconpicker();
			iconButton.on('iconpickerSelected', function (e) {
				iconButton.parent().find('input').attr('value', e.iconpickerValue);
			});
		});


		$('th[data-alterable-type^="select"]').each(function () {
			var index = $(this).index();
			var td = that.closest('tr').find('td:nth-child(' + (index + 1) + ')');

			var validate = $(this).attr('data-alterable-validate').split(' ');
			var dataValidate = '';

			for (var i = 0, n = validate.length ; i < n ; i++) {
				dataValidate += ' data-rule-' + validate[i] + '="true"';
			}

			var data = JSON.parse($(this).attr('data-alterable-value'));
			var options = '<option value="" selected>' + $(this).attr('data-alterable-choose') + '</option>';;
			var option = td.attr('data-alterable-option');
			var selected = false;

			for (var i = 0, n = data.length ; i < n ; i++) {
				if (option == data[i].value && !selected) {
					options += '<option value="' + data[i].value + '" selected>' + data[i].name + '</option>';
					selected = true;
				} else {
					options += '<option value="' + data[i].value + '">' + data[i].name + '</option>';
				}
			}

			td.html('<div class="form-group"><select name="' + $(this).attr('data-alterable-name') + '[]"' + dataValidate + '>' + options + '</select></div>');

			var select = td.find('select');

			if ($(this).attr('data-alterable-type') == 'select-create') {
				select.selectize({
					persist: false,
					create: true,
					render: {
						option_create: function (data, escape) {
							return '<div class="create">Ajouter <strong>' + escape(data.input) + '</strong>&hellip;</div>';
						}
					},
					create: function (input) {
						if (/^[0-9a-zA-ZÀ-ÿ]/i.test(input)) {
							return {
								value: '[new]' + input,
								text: input
							};
						} else {
							alert('La valeur entrée est invalide...');
							return false;
						}
						
					}
				});
			} else {
				select.selectize();
			}

			select.parent().find('input').blur(function () {
				$(this).closest('.form-group').find('select').blur();
			});
		});

		that.parent().remove();
	});
	
	
	
	// Delete publication (modal)

	$('a[data-target="#delete-modal"]').click(function (event) {
		event.preventDefault();
		
		$($(this).attr('data-target')).find('.modal-footer a').attr('href', $(this).attr('data-href'));
	});
});