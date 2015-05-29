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
				return '<div class="create">Ajouter <strong>' + escape(data.input) + '</strong>&hellip;</div>';
			}
		},
		create: function (input) {
			if (/^[a-zA-ZÀ-ÿ][a-zA-ZÀ-ÿ-']* [a-zA-ZÀ-ÿ][a-zA-ZÀ-ÿ-' ]*$/i.test(input)) {
				return {
					value: '[new]' + input,
					text: input
				};
			} else {
				alert('Le nom entré est invalide...');
				return false;
			}
			
		}
	});
});