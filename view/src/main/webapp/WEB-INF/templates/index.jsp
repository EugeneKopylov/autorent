<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>main page</h1>
<table>
  <tr>
    <td>    <div class="main">
            <div class="d2"</div>
            <div class="d3"></div>
            <div class="d4"></div>

        <style>
          * {
          margin: 0;
          padding: 0;
          background-color: #ffffff;
        }
        .main {
          height: 60vh;
          width: 80vw;
          left: -2.5vw;
          position: relative;
        }
        .d2 {
          position: absolute;
          background-image: url(https://www.supercars.net/blog/wp-content/uploads/2020/07/2020-Ferrari-SF90-Stradale-013-1600.jpg);
          background-size: 2700px 1500px;

          height: 55vh;
          width: 25vw;
          left: -30vw;

          background-position: -10vw 50%;
          left: 10vw;

          top: 50%;
          transform: translateY(-50%);
          z-index: 1;
          animation: dd2 10s 2;
          animation-delay: 4s;
        }
        .d3 {
          position: absolute;
          background-image: url(https://www.supercars.net/blog/wp-content/uploads/2020/07/2020-Ferrari-SF90-Stradale-013-1600.jpg);
          background-size: 2900px 1500px;
          overflow: hidden;

          height: 62vh;
          width: 40vw;
          left: 25vw;
          box-shadow: 0px 0px 25px rgba(0, 0, 0, 0.8);
          background-position: -35vw 50%;

          top: 50%;
          transform: translateY(-50%);
          z-index: 3;
          animation: dd3 10s 2;
          animation-delay: 4s;
        }
        .d4 {
          position: absolute;
          overflow: hidden;
          background-image: url(https://www.supercars.net/blog/wp-content/uploads/2020/07/2020-Ferrari-SF90-Stradale-013-1600.jpg);
          background-size: 2700px 1500px;

          height: 53vh;
          width: 25vw;
          left: 60vw;
          background-position: -70vw 50%;

          top: 50%;
          transform: translateY(-50%);
          z-index: 1;
          animation: dd4 10s 2;
          animation-delay: 4s;
        }

        @keyframes dd1 {
          0% {
          }
          50% {
            width: 95vw;
          }
        }
        @keyframes dd12 {
          0% {
          }
          50% {
            background-position: Calc(0vw - 40px) 50%;
          }
        }
        @keyframes dd2 {
          0% {
          }
          50% {
            background-position: Calc(-10vw - 40px) 50%;
          }
        }
        @keyframes dd3 {
          0% {
          }
          50% {
            background-position: Calc(-35vw - 40px) 50%;
          }
        }
        @keyframes dd4 {
          0% {
          }
          50% {
            background-position: Calc(-70vw - 40px) 50%;
          }
        }

        </style>
        </div></td>
  </tr>
</table>
main page of autorent

<jsp:include page="_footer.jsp"/>