/* ==========================================================================
   PRESENTATION CONTROLLER SCRIPT
   ========================================================================== */

document.addEventListener("DOMContentLoaded", () => {
    // DOM Elements
    const slides = document.querySelectorAll(".slide");
    const prevBtn = document.getElementById("prevBtn");
    const nextBtn = document.getElementById("nextBtn");
    const slideIndicator = document.getElementById("slideIndicator");
    const progressBar = document.getElementById("progressBar");
    const fullscreenBtn = document.getElementById("fullscreenBtn");
    const container = document.querySelector(".presentation-container");

    let currentSlideIndex = 0;
    const totalSlides = slides.length;

    // Data for interactive Pipeline Step (Slide 3)
    const pipelineData = {
        1: {
            title: "1. Análisis Léxico (Scanner)",
            desc: "Convierte el flujo de caracteres del código fuente C++ en un flujo ordenado de Tokens. Implementado automáticamente por <code>MiLenguajeLexer.java</code> a partir de las reglas en MAYÚSCULAS de la gramática. Los caracteres no reconocidos disparan excepciones que captura nuestro escuchador personalizado en <code>App.java</code>."
        },
        2: {
            title: "2. Análisis Sintáctico (Parser)",
            desc: "Toma el flujo de Tokens y evalúa si cumple con el orden y estructura definidos por la gramática en minúsculas. Genera el Árbol Sintáctico (AST / Parse Tree) en memoria. En caso de errores estructurales, reporta de inmediato indicando línea y columna."
        },
        3: {
            title: "3. Análisis Semántico (SemanticVisitor)",
            desc: "Audita contextualmente el árbol sintáctico usando <code>SemanticVisitor.java</code> y <code>TablaSimbolos.java</code>. Verifica la compatibilidad de tipos en operaciones y asignaciones, declara y resuelve nombres en múltiples ámbitos (scopes anidados), y levanta warnings si hay variables no usadas."
        },
        4: {
            title: "4. Generación de Código Intermedio (CodigoVisitor)",
            desc: "Recorre recursivamente el AST validado con <code>CodigoVisitor.java</code> para aplanarlo y linealizarlo. Emite cuádruplas formateadas como instrucciones de Código de Tres Direcciones (TAC). Maneja temporales secuenciales (<code>t1, t2...</code>) y etiquetas (<code>L1, L2...</code>) para saltos."
        },
        5: {
            title: "5. Optimización de Código (Optimizador)",
            desc: "Toma el código TAC original y ejecuta pasadas en bucle (Punto Fijo) en <code>Optimizador.java</code>. Aplica plegado y propagación de constantes, simplificaciones algebraicas (identidades neutras y reducción de fuerza para multiplicaciones por 2) y remueve código inalcanzable o temporales no leídos."
        }
    };

    // Initialize slide indicators
    updateHUD();

    // Navigation function
    function goToSlide(index) {
        if (index < 0 || index >= totalSlides) return;

        // Slide animation change
        slides[currentSlideIndex].classList.remove("active");
        currentSlideIndex = index;
        slides[currentSlideIndex].classList.add("active");

        updateHUD();
    }

    function nextSlide() {
        if (currentSlideIndex < totalSlides - 1) {
            goToSlide(currentSlideIndex + 1);
        }
    }

    function prevSlide() {
        if (currentSlideIndex > 0) {
            goToSlide(currentSlideIndex - 1);
        }
    }

    function updateHUD() {
        // Slide counter (1 / 10)
        slideIndicator.textContent = `${currentSlideIndex + 1} / ${totalSlides}`;
        
        // Progress bar width percentage
        const progressPercent = (currentSlideIndex / (totalSlides - 1)) * 100;
        progressBar.style.width = `${progressPercent}%`;

        // Disable buttons at edges
        prevBtn.style.opacity = currentSlideIndex === 0 ? "0.3" : "1";
        prevBtn.style.cursor = currentSlideIndex === 0 ? "not-allowed" : "pointer";
        
        nextBtn.style.opacity = currentSlideIndex === totalSlides - 1 ? "0.3" : "1";
        nextBtn.style.cursor = currentSlideIndex === totalSlides - 1 ? "not-allowed" : "pointer";
    }

    // Event Listeners for controls
    nextBtn.addEventListener("click", nextSlide);
    prevBtn.addEventListener("click", prevSlide);

    // Keyboard Navigation
    document.addEventListener("keydown", (e) => {
        // Only navigate if we are not typing in any input field
        if (document.activeElement.tagName === "INPUT" || document.activeElement.tagName === "TEXTAREA") {
            return;
        }

        switch (e.key) {
            case "ArrowRight":
            case "ArrowDown":
            case "Space":
            case " ":
            case "PageDown":
                e.preventDefault();
                nextSlide();
                break;
            case "ArrowLeft":
            case "ArrowUp":
            case "PageUp":
                e.preventDefault();
                prevSlide();
                break;
        }
    });

    // Fullscreen Mode
    fullscreenBtn.addEventListener("click", () => {
        if (!document.fullscreenElement) {
            container.requestFullscreen().catch(err => {
                console.error(`Error al intentar pantalla completa: ${err.message}`);
            });
            fullscreenBtn.innerHTML = '<i class="fa-solid fa-compress"></i>';
        } else {
            document.exitFullscreen();
            fullscreenBtn.innerHTML = '<i class="fa-solid fa-expand"></i>';
        }
    });

    // Handle ESC key or exit fullscreen change event to update HUD icon
    document.addEventListener("fullscreenchange", () => {
        if (!document.fullscreenElement) {
            fullscreenBtn.innerHTML = '<i class="fa-solid fa-expand"></i>';
        }
    });

    // Interactive flowchart on Slide 3
    const flowSteps = document.querySelectorAll(".flow-step");
    const pipelineDesc = document.getElementById("pipelineDesc");

    flowSteps.forEach(step => {
        step.addEventListener("click", () => {
            // Remove active step status from all
            flowSteps.forEach(s => s.classList.remove("active-step"));
            
            // Add active to clicked step
            step.classList.add("active-step");

            const stepId = step.getAttribute("data-step");
            const stepInfo = pipelineData[stepId];

            if (stepInfo) {
                // Fade out transition
                pipelineDesc.style.opacity = 0;
                
                setTimeout(() => {
                    pipelineDesc.innerHTML = `
                        <h3>${stepInfo.title}</h3>
                        <p>${stepInfo.desc}</p>
                    `;
                    pipelineDesc.style.opacity = 1;
                }, 200);
            }
        });
    });
});
