const API_URL = "http://localhost:8080/api";

// Executa automaticamente assim que a página HTML termina de carregar
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("planosPagina")) {
        carregarPlanosDoBackEnd();
    }
});

// Busca os planos salvos no banco Java e renderiza na tela
async function carregarPlanosDoBackEnd() {
    const container = document.getElementById("planosPagina");
    if (!container) return;

    try {
        const response = await fetch(`${API_URL}/planos`);
        if (!response.ok) throw new Error("Erro ao buscar planos do servidor.");
        
        const planos = await response.json();
        container.innerHTML = ""; // Limpa os cards antigos ou mensagens de carregamento

        if (planos.length === 0) {
            container.innerHTML = "<p class='text-muted'>Nenhum plano cadastrado no momento.</p>";
            return;
        }

        planos.forEach(plano => {
            const card = document.createElement("div");
            // Adiciona as classes CSS idênticas às que estavam no seu index.html original
            card.classList.add("plan-card");
            
            // Se o plano for o Premium, adiciona a classe de destaque visual do seu CSS
            if (plano.nome.toLowerCase() === "premium") {
                card.classList.add("destaque");
            }

            // Mapeia a lista de benefícios vinda do banco (trata se for Array ou String)
            const listaBeneficios = Array.isArray(plano.beneficios)
                ? plano.beneficios.map(b => `<li>${b}</li>`).join("")
                : `<li>${plano.beneficios}</li>`;

            // Renderiza a estrutura HTML do card com os dados dinâmicos da API
            card.innerHTML = `
                <h2>${plano.nome}</h2>
                <p class="price">R$ ${plano.preco}/mês</p>
                <p>${plano.descricao || ""}</p>
                <ul>
                    ${listaBeneficios}
                </ul>
                <button onclick="planSelect('${plano.nome}')">Escolher</button>
            `;
            container.appendChild(card);
        });
    } catch (error) {
        console.error("Erro ao carregar planos:", error);
        container.innerHTML = "<p style='color: red; text-align: center; font-weight: bold;'>Erro ao conectar com o servidor da academia.</p>";
    }
}