<template>

    <v-data-table
        :headers="headers"
        :items="personalPage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PersonalPageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            personalPage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/personalPages'))

            temp.data._embedded.personalPages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.personalPage = temp.data._embedded.personalPages;
        },
        methods: {
        }
    }
</script>

