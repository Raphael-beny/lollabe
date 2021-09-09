<template>
    <main>
        <div class="text-top"><b>LollaBê</b> 𝐿𝑎ç𝑜𝑠 𝑐𝑜𝑚 𝑎𝑚𝑜𝑟 ♡</div>
        <a href="https://www.instagram.com/lollabelacos/" target=" blank">
            <img src="../img/instagram.svg" alt="logo-insta" id="subscribe">
        </a>
        <div class="text-botton">@llolabelacos</div>
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
        justify-content: center;
        align-items: center;
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

    @media (min-width: 700px){
        #subscribe{
            width: 300px;
        }
    }

</style>
