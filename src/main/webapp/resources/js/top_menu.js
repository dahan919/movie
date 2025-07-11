fetch('./top_menu.html')
  .then(response => response.text())
  .then(html => {
    document.getElementById('top_menu_btn').innerHTML = html;
  });