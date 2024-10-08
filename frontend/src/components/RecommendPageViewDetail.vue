<template>

    <v-card outlined>
        <v-card-title>
            RecommendPage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="PersonId" v-model="item.personId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ClassId" v-model="item.classId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ClassName" v-model="item.className" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'RecommendPageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/recommendPages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

