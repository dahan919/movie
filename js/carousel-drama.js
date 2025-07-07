fetch("./carousel-drama.html")
  .then((response) => response.text())
  .then((html) => {
    document.getElementById("carousel_drama").innerHTML = html;

    initCarousel();
  });

function initCarousel() {
  const animationOptions = {
    duration: 1000,
    fill: "backwards",
    iteration: 1,
    easing: "ease",
  };
  const item_container = document.querySelector(".item_container");
  let flag = false;

  document.querySelector(".left_arrow").onclick = () => {
    if (flag) return;
    flag = true;
    let li = item_container.firstElementChild;
    let liWidth = li.clientWidth;
    let style = getComputedStyle(item_container);
    let gap = parseInt(style.gap) || 0;
    let moveWidth = liWidth + gap;

    item_container.style.transition = "transform 1s ease";
    item_container.style.transform = `translateX(-${moveWidth}px)`;

    item_container.addEventListener("transitionend", function handler() {
      item_container.style.transition = "none";
      item_container.style.transform = "translateX(0)";
      item_container.appendChild(item_container.firstElementChild);

      setTimeout(() => {
        item_container.style.transition = "";
      });

      flag = false;
      item_container.removeEventListener("transitionend", handler);
    });
  };

  document.querySelector(".right_arrow").onclick = () => {
    if (flag) return;
    flag = true;

    let li = item_container.lastElementChild;
    let liWidth = li.clientWidth;
    let style = getComputedStyle(item_container);
    let gap = parseInt(style.gap) || 0;
    let moveWidth = liWidth + gap;

    item_container.insertBefore(li, item_container.firstElementChild);
    item_container.style.transition = "none";
    item_container.style.transform = `translateX(-${moveWidth}px)`;

    setTimeout(() => {
      item_container.style.transition = "transform 1s ease";
      item_container.style.transform = "translateX(0)";
    });

    item_container.addEventListener("transitionend", function handler() {
      item_container.style.transition = "";
      flag = false;
      item_container.removeEventListener("transitionend", handler);
    });
  };
}
