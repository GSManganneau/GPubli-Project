$(function () {

	// Active bootstrap tooltips

	$('[data-toggle="tooltip"]').tooltip();




	// Definition and use selectize elements

	$('select.selectize-select-simple').selectize();

	$('select.selectize-select-multiple').selectize({
		plugins: ['remove_button']
	});

	$('select.selectize-select-multiple-create').selectize({
		plugins: ['remove_button'],
		persist: false,
		create: true,
		render: {
			option_create: function (data, escape) {
				return '<div class="create">Ajouter <strong>' + escape(data.input) + '</strong>&hellip;</div>';
			}
		}
	});

	$('select.selectize-select-multiple-create-user').selectize({
		plugins: ['remove_button'],
		persist: false,
		create: true,
		render: {
			option_create: function (data, escape) {
				return '<div class="create">Ajouter <strong>' + escape(data.input.replace('/', ' ')) + '</strong>&hellip;</div>';
			}
		},
		create: function (input) {
			if (/^[a-zA-ZÀ-ÿ][a-zA-ZÀ-ÿ-']*\/[a-zA-ZÀ-ÿ][a-zA-ZÀ-ÿ-' ]*$/i.test(input)) {
				return {
					value: '[new]' + input,
					text: input.replace('/', ' ')
				};
			} else {
				alert('Le nom entré est invalide...\nIl doit être de la forme : Prénom/Nom');
				return false;
			}
			
		}
	});




	// Use of stupidtable

	var sortingTable = $('table').stupidtable();

	sortingTable.on('aftertablesort', function (event, data) {
		$(this).find('th.sort-active').removeClass('sort-active').find('i').removeClass().addClass('fa fa-sort');

		var dir = $.fn.stupidtable.dir;
		var arrow = data.direction === dir.ASC ? 'asc' : 'desc';

		$(this).find('th').eq(data.column).addClass('sort-active').find('i').removeClass().addClass('fa fa-sort-' + arrow);
	});
	
	$('table').find('th').eq(0).stupidsort();




	// Definition and use datetimepicker elements

	$('.datetimepicker-input-date').datetimepicker({
		locale: 'fr',
		format: 'YYYY-MM-DD'
	});




	// Autocomplete

	function Autocomplete(inputSelector) {
		this.input = $(inputSelector);
		this.autocomplete = $('<div class="autocomplete"></div>').insertAfter(inputSelector);


		this.build = function () {
			this.input.on('input', $.proxy(this.get, this));

			this.input.on('focus', $.proxy(function () {
				this.autocomplete.show();
			}, this));

			this.input.on('blur', $.proxy(function () {
				if (!this.autocomplete.is(':hover')) {
					this.autocomplete.hide();
				} else {
					this.input.focus();
				}
			}, this));
		};

		this.get = function () {
			var request = $.ajax({
				type: 'POST',
				dataType: 'json',
				data: {
					'field': $.trim(this.input.val())
				},
				url: 'autocomplete'
			});

			request.done($.proxy(function (data) {
				this.display(data);
			}, this));
		};

		this.display = function (data) {
			var strData = '';

			if (data.publications != null) {
				strData += this.displayData(data.publications, 'Publications', 'book', 'publication');
			}

			if (data.users != null) {
				strData += this.displayData(data.users, 'Utilisateurs', 'user', 'user');
			}

			if (data.teams != null) {
				strData += this.displayData(data.teams, 'Équipes', 'list-alt', 'team');
			}

			if (strData != '') {
				strData = '<div class="panel panel-default">' + strData + '<div class="panel-body text-center"><a href="?page=search-results&query=' + $.trim(this.input.val()) + '">Voir plus de résultats...</a></div></div>';
			}

			this.autocomplete.html(strData);
		};

		this.displayData = function (data, title, icon, page) {
			var strData = '';
			strData += '<div class="panel-heading"><h4 class="panel-title"><span class="glyphicon glyphicon-' + icon + '" aria-hidden="true"></span>&nbsp; ' + title + '</h4></div>';
			strData += '<div class="list-group">';

			for (var i = 0, n = data.length ; i < n ; i++) {
				strData += '<a href="?page=' + page + '&id=' + data[i].id + '" class="list-group-item"><span class="hide-overflow">' + this.bold(data[i].value, $.trim(this.input.val())) + '</span></a>';
			}

			return strData + '</div>';
		};

		this.bold = function (str, input) {
			return str.replace(new RegExp('('+ input +')', 'ig'), '<strong>$1</strong>');
		};

		this.build();
	}

	var autocomplete = new Autocomplete('header .navbar-form input');




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




	// Publications

	$('.panel-publication .panel-body p.resume-ellipsis').dotdotdot({
		ellipsis: '...',
		height: 100,
		watch: 'window'
	});

	$('.panel-publication .panel-body p.detail a').click(function (event) {
		event.preventDefault();

		var publication = $(this).closest('.panel-publication');
		publication.find('p.resume-ellipsis').trigger('destroy');
		publication.find('table').show();
		publication.find('.detail').remove();
	});




	// Delete publication (modal)

	$('a[data-target="#delete-modal"]').click(function (event) {
		event.preventDefault();
		
		$($(this).attr('data-target')).find('.modal-footer a').attr('href', $(this).attr('href'));
	});




	// Pagination

	$('ul.pager .pager-select select').change(function () {
		window.location.replace($(this).attr('data-href') + $(this).val());
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
});