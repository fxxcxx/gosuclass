<template>

    <v-data-table
        :headers="headers"
        :items="classPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ClassPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            classPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/classPages'))

            temp.data._embedded.classPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.classPage = temp.data._embedded.classPages;
        },
        methods: {
        }
    }
</script>

