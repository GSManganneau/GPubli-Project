$(function() {
    var availableTags = [
      "Paris",
      "Franceville",
      "Libreville",
      "Porg-gentil",
      "New-york",
      "Lyon",
      "Casablanca",
      "Barcelone",
      "Madrid",
      "seville",
      "Bamako",
      "Groovy",
      "Haskell",
      "Rouen"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  });

