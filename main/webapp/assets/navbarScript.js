/**
 * 
 */
const hamBurger = document.querySelector(".toggle-btn");

hamBurger.addEventListener("click", function () {
  document.querySelector("#sidebar").classList.toggle("expand");
});

 var currentStep = 0;
    showStep(currentStep);

    function showStep(n) {
        var steps = document.getElementsByClassName("step");
        steps[n].style.display = "block";
        updateProgressBar(n);
        if (n == 0) {
            document.getElementById("prevBtn").style.display = "none";
        } else {
            document.getElementById("prevBtn").style.display = "inline";
        }
        if (n == (steps.length - 1)) {
            document.getElementById("nextBtn").style.display = "none";
            document.getElementById("submitBtn").style.display = "inline";
        } else {
            document.getElementById("nextBtn").style.display = "inline";
            document.getElementById("submitBtn").style.display = "none";
        }
    }

    function nextPrev(n) {
        var steps = document.getElementsByClassName("step");
        steps[currentStep].style.display = "none";
        currentStep += n;
        if (currentStep >= steps.length) {
            document.getElementById("regForm").submit();
            return false;
        }
        showStep(currentStep);
    }

    function updateProgressBar(n) {
        var progressBars = document.getElementsByClassName("progress-bar-custom");
        for (var i = 0; i < progressBars.length; i++) {
            progressBars[i].classList.remove("active");
            progressBars[i].classList.remove("completed");
            if (i < n) {
                progressBars[i].classList.add("completed");
            } else if (i == n) {
                progressBars[i].classList.add("active");
            }
        }
    }
    
    
    
    
    
 