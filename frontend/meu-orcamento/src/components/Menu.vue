<template>
  <div>
    <q-card class="bg-primary q-mb-sm q-mt-sm">
      <q-card-section class="bg-primary">
        <q-input
          ref="filter"
          type="text"
          filled
          v-model="filter"
          label="Pesquisar no Menu"
          @update:model-value="filterMenu"
          :debounce="400"
          dark
          color="white"
        >
          <template v-slot:append>
            <q-icon
              v-if="filter !== ''"
              name="clear"
              class="cursor-pointer"
              @click="resetFilter"
            />
          </template>
        </q-input>
      </q-card-section>
    </q-card>

    <q-list v-for="(item, index) in filtered" :key="index">
      <q-expansion-item
        :label="item.label"
        expand-icon-class="text-white"
        v-model="item.expanded"
        group="menu"
        :icon="item.icon"
        class="text-white text-subtitle1 bg-primary texto"
      >
        <q-separator />
        <q-card>
          <q-list class="bg-secondary" separator>
            <q-item
              :key="index"
              v-for="(child, index) in item.children"
              active-class="menu-item-active-route "
              :to="`${item.path}${child.path}`"
            >
              <q-item-section class="texto">{{ child.label }} </q-item-section>
            </q-item>
          </q-list>
        </q-card>
      </q-expansion-item>
      <q-separator />
    </q-list>

    <q-separator />

    <q-item @click="$emit('logout')" clickable v-ripple>
      <q-item-section avatar>
        <q-icon class="item-icon" color="yellow" name="logout" />
        <q-tooltip class="bg-orange-10 text-white">Sair</q-tooltip>
      </q-item-section>

      <q-item-section class="item-label text-bold text-yellow">
        Sair do Sistema
      </q-item-section>
    </q-item>
    <q-separator />
  </div>
</template>

<script>
import {
  ECadastroLivro,
  EConfigEmprestimo,
  EDevolverLivro,
  EEmprestimoLivro,
  EMovimentacoes,
  EMovimentacoesColaborador,
  ERenovarLivro,
} from "src/enums/routes";
export default {
  data() {
    return {
      search: "",
      expanded: false,
      filter: null,
      filtered: [
        {
          label: "",
          expanded: false,
          icon: null,
          path: null,
          children: [{ path: null, label: null }],
        },
      ],
      items: [
        {
          label: "Cadastros",
          icon: "fas fa-plus-square",
          path: "",
          expanded: false,
          children: [
            {
              label: "Contas",
              path: ECadastroLivro.Path,              
            },
          ],
        },
        // {
        //   label: "Relatórios",
        //   icon: "fas fa-print",
        //   path: "",
        //   expanded: false,
        // children: [
        //   {
        //     label: "Livros",
        //     path: "ERegisterSeparationTables.Path",
        //   },
        // ],
        //   },
      ],
    };
  },

  mounted() {
    this.filtered = [...this.items];
  },

  methods: {
    vaiPraTelaDoColab() {
      window.open("#" + EMovimentacoesColaborador.Path, "_blank");
    },

    filter1(arr, term) {
      var matches = [];

      var self = this;

      if (!Array.isArray(arr)) return matches;

      arr.forEach(function (i) {
        if (i.label.toLowerCase().includes(term.toLowerCase())) {
          const filterData =
            i.children && Array.isArray(i.children)
              ? i.children.filter((values) =>
                  values.label.toLowerCase().includes(term.toLowerCase())
                )
              : [];

          i.children = filterData;

          matches.push(i);
        } else {
          let childResults = self.filter1(i.children, term);
          if (childResults.length)
            matches.push(Object.assign({}, i, { children: childResults }));
        }
      });

      return matches;
    },

    filterMenu() {
      if (this.filter.length === 0) {
        this.filtered = this.items;
        return;
      }

      const result = (items) =>
        items.filter(({ children }) => {
          return children.some((e) =>
            e.label.toLowerCase().includes(this.filter.toLowerCase())
          );
        });

      this.filtered = result(this.items);
    },

    resetFilter() {
      this.filter = "";
      this.filterMenu();
    },
  },
};
</script>

<style scoped>
.menu-title {
  font-size: 1rem !important;
  font-family: "Poppins", sans-serif;
}

.bg-header-expansion-color {
  background-color: #2c373a;
  font-family: "Poppins", sans-serif;
}

.bg-item-expansion-color {
  background-color: #2c373a;
  font-family: "Poppins", sans-serif;
}

.texto {
  font-size: 14px;
  font-family: "Poppins", sans-serif;
  /* line-height: 24px; */

  /* display: table-cell;
  vertical-align: sub;
  width: 100%; */
}

.menu-item-active-route {
  background-color: rgba(0, 0, 0, 0.3);
  color: #e5f835;
  font-family: "Poppins", sans-serif;
}
</style>
