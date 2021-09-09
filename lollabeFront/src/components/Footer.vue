<template>
    <footer>

        <a class="socialLink" href="https://www.instagram.com/lollabelacos/" target=" blank">
            <img src="https://raw.githubusercontent.com/william-costa/wdev-mock-site-resources/master/assets/icons/instagram.svg" alt="instagram">
        </a>
        <a class="socialLink" href="https://www.instagram.com/lollabelacos/" target=" blank">
            <img src="https://raw.githubusercontent.com/william-costa/wdev-mock-site-resources/master/assets/icons/facebook.svg" alt="facebook">
        </a>

    </footer>
</template>

<script>
export default {
    name: 'Footer' 
}
</script>

<style scoped>

    footer{
        height: 90px;
        width: 100%;
        background-color: rgb(245, 184, 194);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .socialLink{
        border: 1px solid white;
        display: flex;
        align-items: center;
        justify-content: center;
        border-radius: 50%;
        width: 40px;
        height: 40px;
        margin: 0 10px;
    }

    .socialLink img{
        width: 20px;
    }

</style>