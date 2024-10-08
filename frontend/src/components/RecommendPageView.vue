<template>

    <v-data-table
        :headers="headers"
        :items="recommendPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RecommendPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "personId", value: "personId" },
                { text: "classId", value: "classId" },
                { text: "className", value: "className" },
            ],
            recommendPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/recommendPages'))

            temp.data._embedded.recommendPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.recommendPage = temp.data._embedded.recommendPages;
        },
        methods: {
        }
    }
</script>

