$(function() {
	var page = window.location.search.split('=')[1];
	var contentPath = 'contents/' + page + '.html';
	var stylePath = 'css/' + page + '.css';
	var scriptPath = 'js/' + page + '.js';

	$.get(contentPath, function(data) {
		$('#content > .container').append(data);
	});

	$.get(stylePath, function(data) {
		$('head').append('<style>' + data + '</style>');
	});

	$.getScript('js/main.js');
	$.getScript(scriptPath);

	$('title').text($('title').text() + ' - ' + page);
});