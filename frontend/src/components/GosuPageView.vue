<template>

    <v-data-table
        :headers="headers"
        :items="gosuPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GosuPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            gosuPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/gosuPages'))

            temp.data._embedded.gosuPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.gosuPage = temp.data._embedded.gosuPages;
        },
        methods: {
        }
    }
</script>

