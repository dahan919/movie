<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.carousel {
  width: 100%;
  height: 300px;
  margin-bottom: 100px;
  display: flex;
  overflow: hidden;
  position: relative;
  font-size: 0;
  border-top: 2px solid #ffc60a;
  border-bottom: 2px solid #ffc60a;
}
.item_container {
  list-style-type: none;
  display: flex;
  flex-flow: row nowrap;
  width: calc(100% * 10);
  gap: 80px;
}
.item_container li {
  width: 200px;
  height: 300px;
}
.item_container img {
  height: 100%;
  object-fit: cover;
}
.left_arrow {
  width: 80px;
  height: 80px;
  background-image: url(/movie/resources/img/left_arrow.png);
  background-size: 100%;
  background-color: transparent;
  border: none;
  left: 0px;
  top: calc(50% - 40px);
  position: absolute;
}
.right_arrow {
  width: 80px;
  height: 80px;
  background-image: url(/movie/resources/img/right_arrow.png);
  background-size: 100%;
  background-color: transparent;
  border: none;
  right: 0px;
  top: calc(50% - 40px);
  position: absolute;
}
.carousel button:hover {
  background-color: rgba(255, 231, 123, 0.911);
}
.carousel button:active {
  background-color: #ffc60a;
}

</style>
</head>
<body>
	<div class="carousel">
	  <ul class="item_container">
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/광장.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/눈물의여왕.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/더글로리.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/모범택시.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/무빙.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/미스터션샤인.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/미지의서울.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/오징어게임.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/우리들의블루스.webp" /></li>
	    <li><img src="${pageContext.request.contextPath}/resources/img_drama/폭싹속았수다.webp" /></li>
	  </ul>
	  <button type="button" class="left_arrow"></button>
	  <button type="button" class="right_arrow"></button>
	</div>
</body>
<script>
		function initCarousel() {
			  const animationOptions = {
			    duration: 1000,
			    fill: "backwards",
			    iteration: 1,
			    easing: "ease",
			  };
		
			  document.querySelectorAll(".carousel").forEach((carousel) => {
			    const item_container = carousel.querySelector(".item_container");
			    const leftArrow = carousel.querySelector(".left_arrow");
			    const rightArrow = carousel.querySelector(".right_arrow");
			    let flag = false;
		
			    leftArrow.onclick = () => {
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
		
			    rightArrow.onclick = () => {
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
			  });
			}
		initCarousel();
</script>
</html>