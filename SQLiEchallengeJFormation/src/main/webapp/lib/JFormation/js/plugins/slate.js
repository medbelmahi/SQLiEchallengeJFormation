$('.nav-search').on('focus', 'input', function() {
  $(this).closest('.nav-search').removeClass('dark');
  $(this).closest('.nav-search').addClass('light');
});

$('.nav-search').on('blur', 'input', function() {
  $(this).closest('.nav-search').removeClass('light');
  $(this).closest('.nav-search').addClass('dark');
});


