import { drizzle } from "drizzle-orm/node-postgres";
import { Client } from "pg";
import * as schema from "../src/schema";

import { Elysia } from "elysia";
import { dummyProducts } from "../dummyProducts";
import { file } from "bun";

// or
const client = new Client({
  host: "127.0.0.1",
  port: 5432,
  user: "manik",
  database: "db_cashier",
});
await client.connect();
const db = drizzle(client, { schema, logger: true });

const basePath = "./src/images/";

async function seedProducts() {
  // for (let i = 0; i < dummyProducts.length; i++) {
  //   let filePath = `${basePath}${dummyProducts[i].image}`;

  //   // Membaca file gambar
  //   const fileBuffer = await file(filePath).arrayBuffer();

  //   // Mengonversi fileBuffer ke dalam format Base64
  //   const base64Image = Buffer.from(fileBuffer).toString("base64");

  //   // Menyimpan gambar dalam bentuk Base64 ke dalam properti image produk
  //   dummyProducts[i].image = base64Image;
  // }

  // Memasukkan produk ke dalam database
  await db.insert(schema.products).values(dummyProducts);

  return new Response("Anjer");
}

new Elysia()
  .get("/products/seed", seedProducts)
  .get("/products", ({ params: { id } }) => id)
  .post("/form", ({ body }) => body)
  .listen(9000, () => console.log("Listening on http://localhost:9000"));
