fetch('./footer.html')
    .then(response => response.text())
    .then(html => {
    document.getElementById('footer_text').innerHTML = html;
});