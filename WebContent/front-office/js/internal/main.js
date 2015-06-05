$(function() {
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
				'type': 'POST',
				'dataType': 'json',
				'data': {
					'field': $.trim(this.input.val())
				},
				'url': 'autocomplete.json'
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
				strData += '<a href="?page=' + page + '&id=' + data[i].id + '" class="list-group-item">' + this.bold(data[i].value, $.trim(this.input.val())) + '</a>';
			}

			return strData + '</div>';
		};

		this.bold = function (str, input) {
			return str.replace(new RegExp('('+ input +')', 'ig'), '<strong>$1</strong>');
		};

		this.build();
	}

	var autocomplete = new Autocomplete('header .navbar-form input');
});