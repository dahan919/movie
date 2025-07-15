<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css" />
    <link rel="stylesheet" href="./css/footer.css" />
    <style>
      html,
      body {
        width: 100%;
        height: 100%;
        background-color: black;
      }
      * {
        margin: 0;
        padding: 40 auto;
      }
      .wrapper {
        display: flex;
        flex-direction: column;
        min-height: 100vh;
      }
      .container {
        width: 100vw;
        position: relative;
        display: flex;
        justify-content: center;
        align-items: center;
        flex: 1;
        position: relative;
      }
      .container * {
        z-index: 1;
      }
      .container::before {
        content: "";
        position: absolute;
        width: 100%;
        height: 100%;
        background-image: url("./img/배경화면.jpg");
        background-repeat: repeat;
        background-size: 600px 600px;
        filter: blur(3px) brightness(0.5);
        z-index: 0;
      }
      .box {
        margin-top: 60px;
        padding: 10px;
        width: 100%;
        height: 400px;
        background-color: rgba(0, 0, 0, 0.5);
        display: flex;
        justify-content: center;
        align-items: center;
      }
      .box_content {
        width: 80%;
        height: 100%;
        display: flex;
        flex-flow: row nowrap;
        justify-content: center;
        gap: 20px;
      }
      .box_text {
        color: white;
        display: flex;
        flex-flow: column nowrap;
        gap: 20px;
      }
      .score {
        display: flex;
        flex-flow: row nowrap;
        align-items: center;
      }
      .score p {
        font-size: 1.2em;
      }
      .star {
        display: flex;
        flex-direction: row-reverse;
        justify-content: flex-end;
        font-size: 2em;
        cursor: pointer;
      }

      .star span {
        color: #ccc;
        transition: color 0.2s;
      }

      .star span.selected,
      .star span:hover,
      .star span:hover ~ span {
        color: gold;
      }
    </style>
  </head>
  <script>
    window.onload = () => {
      document.querySelectorAll(".star span").forEach(function (star) {
        star.addEventListener("click", function () {
          let value = this.getAttribute("data-value");
          document.getElementById("star_value").value = value;
          document.querySelectorAll(".star span").forEach(function (s) {
            s.classList.toggle(
              "selected",
              s.getAttribute("data-value") <= value
            );
          });
        });
      });
    };
  </script>
  <body>
    <div class="wrapper">
      <div class="container">
        <div class="main_container">
          <div id="top_menu_btn"></div>
          <hr color="#ffc60a" />
          <div class="box">
            <div class="box_content">
              <img src="./img-movie/괴물.webp" />
              <div class="box_text">
                <h4>주요 줄거리</h4>
                <div class="score">
                  <p>평 점 :</p>
                  <div class="star">
                    <span data-value="5">&#9733;</span>
                    <span data-value="4">&#9733;</span>
                    <span data-value="3">&#9733;</span>
                    <span data-value="2">&#9733;</span>
                    <span data-value="1">&#9733;</span>
                  </div>
                </div>
                <input type="hidden" id="star_value" value="0" />
                <p>
                  싱글맘 사오리는 아들 미나토의 이상 행동(자해, 물통 흙, 신발 한
                  짝 분실 등)을 발견하고, 담임교사 호리 선생이 학대했다고
                  의심합니다. 학교는 형식적 사과만 반복하며 진실을 은폐하고,
                  사오리는 호리 선생을 압박합니다. 결국 호리는 미나토가 동급생
                  요리를 괴롭힌다고 주장하며 반전됩니다.
                </p>
              </div>
            </div>
          </div>
          <div class="box">
            <div class="box_content">
              <img src="./img-movie/괴물.webp" />
              <div class="box_text">
                <h4>주요 줄거리</h4>
                <div class="score">
                  <p>평 점 :</p>
                  <div class="star">
                    <span data-value="5">&#9733;</span>
                    <span data-value="4">&#9733;</span>
                    <span data-value="3">&#9733;</span>
                    <span data-value="2">&#9733;</span>
                    <span data-value="1">&#9733;</span>
                  </div>
                </div>
                <input type="hidden" id="star_value" value="0" />
                <p>
                  싱글맘 사오리는 아들 미나토의 이상 행동(자해, 물통 흙, 신발 한
                  짝 분실 등)을 발견하고, 담임교사 호리 선생이 학대했다고
                  의심합니다. 학교는 형식적 사과만 반복하며 진실을 은폐하고,
                  사오리는 호리 선생을 압박합니다. 결국 호리는 미나토가 동급생
                  요리를 괴롭힌다고 주장하며 반전됩니다.
                </p>
              </div>
            </div>
          </div>
          <div class="box">
            <div class="box_content">
              <img src="./img-movie/괴물.webp" />
              <div class="box_text">
                <h4>주요 줄거리</h4>
                <div class="score">
                  <p>평 점 :</p>
                  <div class="star">
                    <span data-value="5">&#9733;</span>
                    <span data-value="4">&#9733;</span>
                    <span data-value="3">&#9733;</span>
                    <span data-value="2">&#9733;</span>
                    <span data-value="1">&#9733;</span>
                  </div>
                </div>
                <input type="hidden" id="star_value" value="0" />
                <p>
                  싱글맘 사오리는 아들 미나토의 이상 행동(자해, 물통 흙, 신발 한
                  짝 분실 등)을 발견하고, 담임교사 호리 선생이 학대했다고
                  의심합니다. 학교는 형식적 사과만 반복하며 진실을 은폐하고,
                  사오리는 호리 선생을 압박합니다. 결국 호리는 미나토가 동급생
                  요리를 괴롭힌다고 주장하며 반전됩니다.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="footer_text"></div>
    </div>
    <script src="./js/header.js"></script>
    <script src="./js/footer.js"></script>
  </body>
</html>
