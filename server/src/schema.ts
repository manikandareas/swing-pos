import { integer, pgTable, serial, text, uuid } from "drizzle-orm/pg-core";

export const employee = pgTable("users", {
  id: uuid("id").primaryKey().defaultRandom(),
  username: text("name").notNull(),
  hashedPassword: text("hashed_password").notNull(),
});

// export const members = pgTable("members", {
//     id: uuid("id").primaryKey().defaultRandom(),
//     name: text("name").notNull(),
// })

// export const suppliers = pgTable("suppliers", {
//     id: uuid("id").primaryKey().defaultRandom(),
//     name: text("name").notNull(),
// })

// export const products = pgTable("products", {
//     id: serial("id").primaryKey(),
//     stock: integer("stock").notNull(),
//     price: integer("price").notNull(),

// })

// export const salesTransactions = pgTable("sales_transactions", {

// })

// export const purchaseTransactions = pgTable("purchase_transactions", {

// })
