<template>
    <header>
        <nav class="container">

        <a href="/"><img alt="lollabe" id="logo" src="../img/lollabe.jpeg"></a>

        <img v-on:click="openMenu" src="../img/menu.svg" alt="Abrir menu" id="menu-button">

        <div v-on:click="closeMenu" id="menu-overlay" v-if="menuActive"></div>

        <div id="menu-items" :class="{active:menuActive}">
           
           <img alt="lollabe" id="menu-logo" src="../img/lollabe.jpeg">
            
        </div>
        </nav>
    </header>
</template>

<script>


export default {
    name:'Header',
    data(){
        return{
            menuActive: false
        }
    },
    methods:{
        openMenu: function(){
            this.menuActive = true;
        },
        closeMenu: function(){
            this.menuActive = false;
        },
    }
        
}
</script>

<style scoped>

header{
  background-color: var(--color-background-nav);
  width: 100%;
  height: 90px;
  display: flex;
  justify-content: center;
  align-items: center;
}

nav{
    display: flex;
    justify-content: space-between;
    height: 90px;
    align-items: center;
}

#logo{
  width: 90px;
}

#menu-button{
    width: 55px;
    cursor: pointer;
}

#menu-overlay{
    position: fixed;
    top: 0;
    left: 0;
    width: 40%;
    height: 100vh;
    background-color: black;
    opacity: 0.5;
}

#menu-logo{
    width: 110px;
    margin-top: 30px;
    margin-bottom: 10px;
}

#menu-items{
    position: fixed;
    top: 0;
    right: 0;
    background-color: #ffe1e6;
    width: 60%;
    height: 100vh;
    display: none;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
}

#menu-items.active{
    display: flex;
}

ul{
    list-style: none;
    text-align: center;
    height: 90px;
    align-items: center;

}

ul li{
    margin: 20px 0px;
}

ul li a{
    color: black;
}

.cadastrar{
   margin: 420px 0px;
}

@media (min-width: 700px){
    #menu-button,
    #menu-logo,
    #menu-overlay{
        display: none;
    }
    #menu-items{
        display: flex;
        position: static;
        height: 90px;
        width: auto;
    }

    #menu-button{
        text-decoration: none;
        transition: 0.2s opacity;
    }

    #menu-button:hover{
        opacity: 0.8;
    }

    ul{
        display: flex;
        flex-direction: row;
    }

    ul li{
        margin: 0;
        margin-left: 20px;
    }


}



</style>
