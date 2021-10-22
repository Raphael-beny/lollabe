<template>
    <main>
        <div class="principal">
                <img src="../img/aurora1.jpeg" alt="aurora1" id="aurora1">
                <img src="../img/aurora2.jpeg" alt="aurora2" id="aurora2">
            <div class="instagram-logo">
                <h2><b>LollaBê</b> 𝐿𝑎ç𝑜𝑠 𝑐𝑜𝑚 𝑎𝑚𝑜𝑟 ♡</h2> 
                    <a href="https://www.instagram.com/lollabelacos/" target=" blank">
                <img src="../img/instagram.svg" alt="logo-insta" id="subscribe">
                <h3>@llolabelacos</h3>
                    </a></div>
        </div>
    </main>
</template>

<script>

export default{
    name: 'Home'
}

</script>

<style scoped>

    main{
        background-color: var(--color-background-home);
        
    }

    .text-top{
        color: rgb(34, 73, 57);
        font-size: 22px;
        margin-bottom: 20px;
    }

    #subscribe{
        width: 220px;
    }

    .text-botton{
        color: rgb(34, 73, 57);
        font-size: 18px;
        margin-top: 20px;
    }

    .instagram-logo{
        
        align-items: center;
    }

    @media (min-width: 700px){
        #aurora1, #aurora2{
            width: 450px;
        }

        .principal{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin: 100px;
            justify-items: center;
        
        }

        
    }

</style>
